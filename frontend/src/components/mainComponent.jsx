import React from 'react';
import img from '../image/Programmer-PNG-Photos-PhotoRoom (1).png'
import img2 from '../image/147-e1541573547815-PhotoRoom.png'
import img3 from '../image/images-PhotoRoom.png'

export const MainComponent = () => {
    return (
        <div className='container-info-main-theme'>
            <div className='info-main-theme'>
                <img className='img2-main' src={ img } width={ 200 }/>
                <h1>Sed aremque laudantium, totam</h1>
                <p>
                    sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et
                    doloresit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut
                    labore et
                    doloresit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut
                    labore et
                    dolore
                </p>
            </div>
            <div className='info-main-theme'>
                <img className='img-main' src={ img2 } width={ 300 }/>
                <h1>a non nabore et dolore</h1>
                <p>
                    sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et
                    dolore
                </p>
            </div>
            <div className='info-main-theme'>
                <img className='img2-main' src={ img3 } width={ 300 }/>
                <h1>nulla pariatur?</h1>
                <p>
                    sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et
                    doloresit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut
                    labore et
                    dolore
                </p>
            </div>
        </div>
    );
};