import React, {useRef} from 'react';
import { useForm } from 'react-hook-form';
import {EMAIL_REGEXP} from "../utils/consts";

export const LoginForm = () => {
    const { register, handleSubmit, watch, formState: { errors } } = useForm();

    const onSubmit = data => console.log(data);

    return (
        <form className='container-form-auth' onSubmit={handleSubmit(onSubmit)}>
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
            <input type="submit" />
        </form>
    );
};