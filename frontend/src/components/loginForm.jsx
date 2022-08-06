import React from 'react';
import { useForm } from 'react-hook-form';
import { EMAIL_REGEXP } from "../utils/consts";
import { useSelector } from 'react-redux';
import { axiosLogin } from '../api/axios/axiosClient';
import { updateToken } from '../api/axios/jwt/jwtLocalStorage';

export const LoginForm = () => {

    const { setAuth } = useSelector(state => state)

    const { register, handleSubmit, watch, formState: { errors } } = useForm();

    const onSubmit = (data) => {
        console.log(data);
        axiosLogin({email: data.email, password: data.password})
            .then((r) => {
                updateToken(r.data.token)
                setAuth(true)
            })
    }

    return (
        <form className='container-form-auth' onSubmit={ handleSubmit(onSubmit) }>
            <h2>Войти</h2>
            <div className='container-radio-auth'>
                <label className='label-auth'>Email</label>
                <input className='input-auth' { ...register("email", {
                    required: true,
                    pattern: EMAIL_REGEXP
                }) } />
                { errors.email && <span style={ { color: 'red' } }>email should be correct</span> }
            </div>
            <div className='container-radio-auth'>
                <label className='label-auth'>Password</label>
                <input className='input-auth' type='password' { ...register("password", {
                    required: "You must specify a password",
                    minLength: {
                        value: 8,
                        message: "Password must have at least 8 characters"
                    }
                }) } />
                { errors.password && <span style={ { color: 'red' } }>{ errors.password.message }</span> }
            </div>
            <input className='btn-submit' type="submit"/>
        </form>
    );
};