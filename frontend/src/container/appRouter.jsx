import React, { useEffect, useState } from 'react';
import { Switch } from "react-router-dom";
import { useDispatch } from 'react-redux';
import { authRoutes, publicRoutes } from '../routes';
import { AuthContainer } from './authContainer';
import { Main } from './main';
// import { isTokenValid } from '../api/jwtLocalStorage';

export const AppRouter = () => {
    const dispatch = useDispatch();
    const [isAuth, setAuth] = useState(
        // isTokenValid
        false
    )

    useEffect(() => {
        dispatch({
            type: 'AUTH', payload: {
                setAuth: setAuth
            }
        })
    })

    return (
        isAuth ?
            <Switch>
                <Main authRoutes={ authRoutes }/>
            </Switch>
            :
            <Switch>
                <AuthContainer publicRoutes={ publicRoutes }/>
            </Switch>
    );
};

