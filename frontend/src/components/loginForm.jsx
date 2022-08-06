import React, {useRef} from 'react';
import { useForm } from 'react-hook-form';
import {EMAIL_REGEXP} from "../utils/consts";

export const LoginForm = () => {
    const { register, handleSubmit, watch, formState: { errors } } = useForm();

    const password = useRef({});
    password.current = watch("password", "");

    const onSubmit = data => console.log(data);

    return (
        <form onSubmit={handleSubmit(onSubmit)}>

            <br/>
            <label>Email</label>
            <input {...register("email", {
                required: true,
                pattern: EMAIL_REGEXP
            })} />
            {errors.email && <span>email should be correct</span>}

            <br/>
            <label>Password</label>
            <input type='password' {...register("password", {
                required: "You must specify a password",
                minLength: {
                    value: 8,
                    message: "Password must have at least 8 characters"
                }
            })} />
            {errors.password && <span>{errors.password.message}</span>}

            <br/>
            <label>Repeat password</label>
            <input type="password" {...register("password_repeat",{
                    validate: value =>
                        value === password.current || "The passwords do not match"
                })}
            />
            {errors.password_repeat && <p>{errors.password_repeat.message}</p>}


            <input type="submit" />
        </form>
    );
};