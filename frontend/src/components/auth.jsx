import React from 'react';
import {RegistrationForm} from './registrationForm';
import {LoginForm} from "./loginForm";

export const Auth = () => {
    return (
        <div>
            <RegistrationForm/>
            <LoginForm/>
        </div>
    );
};