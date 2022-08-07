import React, { useState } from 'react';
import { RegistrationForm } from './registrationForm';
import { LoginForm } from "./loginForm";

export const Auth = () => {
    const [isLogin, setIsLogin] = useState(false)

    const toggleFormType = () => {
        setIsLogin((prevState) => !prevState)
    }

    return (
        <div>
            { isLogin
                ? (
                    <>
                        <RegistrationForm/>
                        <p className='req-reg'> Already have account?
                            <a className='info text-decoration-none' role='button'
                               onClick={ toggleFormType }> Request authorization. </a>
                        </p>
                    </>
                ) : (
                    <>
                        <LoginForm/>
                        <p className='req-reg'> Not a member?
                            <a className='info text-decoration-none' role='button'
                               onClick={ toggleFormType }> Request registration. </a>
                        </p>
                    </>
                )
            }
        </div>
    );
};