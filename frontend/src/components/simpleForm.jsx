import React from 'react';
import { useForm } from 'react-hook-form';

export const SimpleForm = () => {
    const { register, handleSubmit, watch, formState: { errors } } = useForm();
    const onSubmit = data => console.log(data);

    return (
        <form onSubmit={handleSubmit(onSubmit)}>
            <input {...register("firstName", { required: true, pattern: /^[A-Za-z]+$/i })} />
            {errors.firstName && <span>Firstname should contains only latin letters</span>}
            <input {...register("lastName", { required: true, pattern: /^[A-Za-z]+$/i })} />
            {errors.lastName && <span>LastName should contains only latin letters</span>}
            <input type="number" {...register("age", {
                // valueAsNumber: true,
                min: 18,
                max: 99
            })} />
            {errors.age && <span>Age can't be less than 18 and more than 99</span>}
            <input type="submit" />
        </form>
    );
};