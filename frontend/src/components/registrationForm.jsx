import React, { useRef } from 'react';
import { useForm } from 'react-hook-form';
import { EMAIL_REGEXP } from "../utils/consts";

export const RegistrationForm = () => {
    const { register, handleSubmit, watch, formState: { errors } } = useForm();

    const password = useRef({});
    password.current = watch("password", "");

    const onSubmit = data => console.log(data);

    return (
        <form onSubmit={ handleSubmit(onSubmit) }>

            <br/>
            <label>Choose your role</label>
            {/*<fieldset>*/}
                <input type="radio" { ...register('radio') } value="teacher"/>
                <label htmlFor='teacher'>teacher</label>
            <input type="radio" { ...register('radio') } value="student"/>
                <label htmlFor='student'>student</label>

            {/*</fieldset>*/}

            <br/>
            <label>First name</label>
            <input { ...register("firstName", {
                required: true,
                pattern: {
                    value: /^[A-Za-z]+$/i,
                    message: 'First name must contain only Latin letters'
                }
            }) } />
            { errors.firstName && <span>{ errors.firstName.message }</span> }

            <br/>
            <label>Last name</label>
            <input { ...register("lastName", {
                required: true,
                pattern: {
                    value: /^[A-Za-z]+$/i,
                    message: 'Last name must contain only Latin letters'
                }
            }) } />
            { errors.lastName && <span>{ errors.lastName.message }</span> }

            <br/>
            <label>Birth date</label>
            <input type="date" { ...register("birthDate", {
                required: true
            }) } />

            <br/>
            <label>Interests</label>
            <select { ...register("interests", { required: true }) }>
                <option value="Frontend">Frontend</option>
                <option value="Backend">Backend</option>
                <option value="Analytics">Data Analyst</option>
                <option value="Data Science">Data Analyst</option>
                <option value="Data Analytics">Data Analyst</option>
                <option value="Q&A">Q&A</option>
                <option value="NodeJS">NodeJS</option>
                <option value="DevOps">DevOps</option>
            </select>

            <br/>
            <label>Email</label>
            <input { ...register("email", {
                required: true,
                pattern: EMAIL_REGEXP
            }) } />
            { errors.email && <span>email should be correct</span> }

            <br/>
            <label>Password</label>
            <input type='password' { ...register("password", {
                required: "You must specify a password",
                minLength: {
                    value: 8,
                    message: "Password must have at least 8 characters"
                }
            }) } />
            { errors.password && <span>{ errors.password.message }</span> }

            <br/>
            <label>Repeat password</label>
            <input type="password" { ...register("password_repeat", {
                validate: value =>
                    value === password.current || "The passwords do not match"
            }) }
            />
            { errors.password_repeat && <p>{ errors.password_repeat.message }</p> }


            <input type="submit"/>
        </form>
    );
};