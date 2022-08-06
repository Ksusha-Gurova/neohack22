import React from "react";
import tlg from '../image/Telegram.png'
import vk from '../image/VK.png'
import ws from '../image/Whatsapp.png'
import { Link } from 'react-router-dom';


export const Footer = () => {
    return (
        <div className='footer'>
            <div className='content-footer'>
                <div className='card-content'>
                    <div className='brand'>
                        IT-BRAINS
                    </div>
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
                    <div>
                        <Link className='link-footer' to='/'>
                            <img className='social-network' src={ vk } width='31px'/>
                        </Link>
                        <Link className='link-footer' to='/'>
                            <img className='social-network' src={ tlg }/>
                        </Link>
                        <Link className='link-footer' to='/'>
                            <img className='social-network' src={ ws }/>
                        </Link>
                    </div>
                </div>
            </div>
        </div>
    )
};