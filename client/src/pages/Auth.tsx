import { useNavigate } from 'react-router-dom';
import homeSvg from '../assets/home.svg';
import React, { useState } from 'react';
import axios, { AxiosError } from 'axios';
import { toast } from 'react-toastify';

const Auth = () => {

    const navigate = useNavigate();

    const [loginPage, setLoginPage] = useState(true);

    const [loginForm, setLoginForm] = useState({
        email: '',
        password: ''
    });

    const [registerForm, setRegisterForm] = useState({
        name: '',
        email: '',
        password: ''
    });

    const submitLoginForm = async (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        console.log(loginForm);
        try {
            const response = await axios.post('/login', loginForm);
            if (response.status == 200) {
                toast.success(response.data.message);
                navigate('/home');
            }
            console.log(response);
        } catch (err) {
            console.warn(err);
            if (axios.isAxiosError(err)) {
                if (err.response?.status == 400) {
                    toast.info(err.response.data.message);
                } else if (err.response?.status == 404) {
                    toast.warn(err.response.data.message);
                }
            } else {
                toast.error('something went wrong please try after sometime');
            }
        }
    }

    const submitRegisterForm = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        console.log(registerForm);
    }

    return (
        <div className='flex h-screen p-10'>
            <div className='w-1/2 flex items-center justify-center'>
                <div className='flex flex-col w-1/2 gap-2'>
                    <p className='text-5xl font-bold text-blue-600'>Unlock the Future of Conversations</p>
                    <p className='text-lg text-gray-600'>Join the ultimate chat experience where your words come to life. Connect, share, and enjoy seamless conversations with friends and colleagues.</p>
                    {loginPage && (
                        <form className='flex flex-col gap-2' onSubmit={submitLoginForm}>
                            <input name='email' className='border border-slate-200 px-5 py-2 outline-none w-full' type="text"
                                placeholder='john@gmail.com' value={loginForm.email}
                                onChange={(e) => setLoginForm({ ...loginForm, email: e.target.value })} />
                            <input name='password' className='border border-slate-200 px-5 py-2 outline-none w-full' type="text" placeholder='password' value={loginForm.password} onChange={(e) => setLoginForm({ ...loginForm, password: e.target.value })} />
                            <button className='bg-primary text-white px-5 py-2' type='submit'>submit</button>
                            <div className='flex gap-2 items-center justify-center'>
                                Don't have an account? <span className='text-red-500 cursor-pointer' onClick={() => { setLoginPage(false) }}>Register Now!</span>
                            </div>
                        </form>
                    )}

                    {!loginPage && (
                        <form className='flex flex-col gap-2' onSubmit={submitRegisterForm}>
                            <input name='name' className='border border-slate-200 px-5 py-2 outline-none w-full' value={registerForm.name} onChange={(e) => { setRegisterForm({ ...registerForm, name: e.target.value }) }} type="text" placeholder='John Doe' />
                            <input name='email' className='border border-slate-200 px-5 py-2 outline-none w-full' value={registerForm.email} type="text" placeholder='john@gmail.com' onChange={(e) => { setRegisterForm({ ...registerForm, email: e.target.value }) }} />
                            <input name='password' value={registerForm.password} className='border border-slate-200 px-5 py-2 outline-none w-full' type="text" placeholder='password' onChange={(e) => { setRegisterForm({ ...registerForm, password: e.target.value }) }} />
                            <button className='bg-primary text-white px-5 py-2' type='submit'>register</button>
                            <div className='flex gap-2 items-center justify-center'>
                                Already have an account? <span className='text-red-500 cursor-pointer' onClick={() => { setLoginPage(true) }}>Login</span>
                            </div>
                        </form>
                    )}
                </div>
            </div>
            <div className='w-1/2 h-full flex items-center justify-center'>
                <img className='h-full w-full' src={homeSvg} alt="" />
            </div>
        </div>
    )
}

export default Auth