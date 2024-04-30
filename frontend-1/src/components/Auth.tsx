import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const Auth = () => {

    const navigate = useNavigate();

    const [login, setLogin] = useState(true);

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const [name, setName] = useState('');
    const [phone, setPhone] = useState('');
    const [gender, setGender] = useState('');
    const [occupation, setOccupation] = useState('');
    const [address, setAddress] = useState('');
    const [avatar, setAvatar] = useState<File | null>(null);

    const loginSubmit = async () => {
        try {
            const response = await axios.post('auth/login', { email, password });
            console.log(response.data.message);
            localStorage.setItem('token', response.data.message);
            navigate('home');
        } catch (err) {
            console.log(err);
        }
    }

    const signupSubmit = async () => {
        try {
            const formData = new FormData();
            formData.append('name', name);
            formData.append('email', email);
            formData.append('password', password);
            formData.append('phone', phone);
            formData.append('gender', gender);
            formData.append('occupation', occupation);
            formData.append('address', address);
            if (avatar) {
                formData.append('profilePhoto', avatar);
            }
            const response = await axios.post('auth/register', formData);
            console.log(response.data.message);
        } catch (err) {
            console.log(err);
        }
    }

    return (
        <div className='h-screen w-full flex items-center justify-center'>
            {/* signup */}
            {!login && (
                <div className='flex flex-col w-1/4'>
                    <div className='border border-black py-1 px-2 m-1'>
                        <input className='w-full outline-none border-none' type="text" placeholder='Name' onChange={(e) => setName(e.target.value)} />
                    </div>
                    <div className='border border-black py-1 px-2 m-1'>
                        <input className='w-full outline-none border-none' type="text" placeholder='Gender' onChange={(e) => setGender(e.target.value)} />
                    </div>
                    <div className='border border-black py-1 px-2 m-1'>
                        <input className='w-full outline-none border-none' type="text" placeholder='Email' onChange={(e) => setEmail(e.target.value)} />
                    </div>
                    <div className='border border-black py-1 px-2 m-1'>
                        <input className='w-full outline-none border-none' type="text" placeholder='Phone' onChange={(e) => setPhone(e.target.value)} />
                    </div>
                    <div className='border border-black py-1 px-2 m-1'>
                        <input className='w-full outline-none border-none' type="text" placeholder='Password' onChange={(e) => setPassword(e.target.value)} />
                    </div>
                    <div className='border border-black py-1 px-2 m-1'>
                        <input className='w-full outline-none border-none' type="text" placeholder='Occupation' onChange={(e) => setOccupation(e.target.value)} />
                    </div>
                    <div className='border border-black py-1 px-2 m-1'>
                        <input className='w-full outline-none border-none' type="text" placeholder='Address' onChange={(e) => setAddress(e.target.value)} />
                    </div>
                    <div className='border border-black py-1 px-2 m-1'>
                        <input className='w-full outline-none border-none' type="file" onChange={(e) => setAvatar(e.target.files?.[0] ?? null)} />
                    </div>
                    <button className='bg-blue-500 m-1 py-1 px-2 text-white' onClick={signupSubmit}>REGISTER</button>
                    <div className='flex flex-col items-center cursor-pointer'>
                        <p onClick={() => setLogin(true)}>Already have an Account?</p>
                    </div>
                </div>
            )}

            {/* login */}
            {login && (
                <div className='flex flex-col w-1/4'>
                    <div className='border border-black py-1 px-2 m-1'>
                        <input className='w-full outline-none border-none' type="text" placeholder='Email' onChange={(e) => setEmail(e.target.value)} />
                    </div>
                    <div className='border border-black py-1 px-2 m-1'>
                        <input className='w-full outline-none border-none' type="text" placeholder='Password' onChange={(e) => setPassword(e.target.value)} />
                    </div>
                    <button className='bg-blue-500 m-1 py-1 px-2 text-white' onClick={loginSubmit}>LOGIN</button>
                    <div className='flex flex-col items-center cursor-pointer'>
                        <p onClick={() => setLogin(false)}>Create Account?</p>
                    </div>
                </div>
            )}
        </div>
    )
}

export default Auth;
