import React from 'react';
import BasicCard from '../components/MUIcomponets/menuMUI';
import { Grid } from '@mui/material';

export const ThemeContainer = () => {

    const cards = [1, 2, 3, 4, 5, 6, 7]
    return (
            <Grid container spacing={ { xs: 2 } } columns={ { xs: 1, sm: 8, md: 12 } }
                  sx={ { p: 5, background: '#f3fbff' } }>
                { cards.map((card) => {
                        return (
                            <Grid key={ card } item xs={ 3 } md={ 4 } sm={ 4 }>
                                <BasicCard/>
                            </Grid>
                        )
                    }
                ) }
            </Grid>
    );
};

