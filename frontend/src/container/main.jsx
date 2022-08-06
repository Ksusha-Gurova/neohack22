import React from 'react';
import { Header } from '../components/header';
import { Footer } from '../components/footer';
import { Route } from 'react-router-dom';

export const Main = ({ authRoutes }) => {
    console.log("authRoutes", authRoutes);
    return (
        <div>
            <Header/>
            {
                authRoutes.map(({ path, Component }) =>
                    <Route key={ path } path={ path } component={ Component } exact/>)
            }
            {/*<Redirect to={ ROOT }/>*/ }
            <Footer/>
        </div>
    );
};

