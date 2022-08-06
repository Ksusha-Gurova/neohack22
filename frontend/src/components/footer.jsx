import React from "react";
import { Link } from 'react-router-dom';


export const Footer = () => {
    return (
        <div className='footer'>
            <div className='content-footer'>
                <div className='card-content'>
                    <a className='brand' href='/'>IT-BRAINS</a>
                    <div>
                        <ul className='menu-footer'>
                            <li>
                                <Link className='link-footer' to='/'>Избранное</Link>
                            </li>
                            <li>
                                <Link className='link-footer' to='/'>Контакты</Link>
                            </li>
                        </ul>
                    </div>
                    <div>
                        <ul className='menu-footer'>
                            <li>
                                <Link className='link-footer' to='/'>Условия сервиса</Link>
                            </li>
                            <li>
                                <span className='menu-language'>
                                <Link className='link-footer' to='/'>Рус</Link>
                            </span>
                                <span className='menu-language'>
                                <Link className='link-footer' to='/'>Eng</Link>
                            </span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    )
};