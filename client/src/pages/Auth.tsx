import { useNavigate } from 'react-router-dom';
import homeSvg from '../assets/home.svg';

const Auth = () => {

    const navigate = useNavigate();

    const changeUrl = () => {
        navigate('/home');
    }

    return (
        <div className='flex h-screen p-10'>
            <div className='w-1/2 flex items-center justify-center'>
                <div className='flex flex-col w-1/2 gap-2'>
                    <p className='text-5xl font-bold text-blue-600'>Unlock the Future of Conversations</p>
                    <p className='text-lg text-gray-600'>Join the ultimate chat experience where your words come to life. Connect, share, and enjoy seamless conversations with friends and colleagues.</p>
                    <input className='border border-slate-200 px-5 py-2 outline-none w-full' type="text" placeholder='john@gmail.com' />
                    <input className='border border-slate-200 px-5 py-2 outline-none w-full' type="text" placeholder='password' />
                    <button className='bg-primary text-white px-5 py-2' onClick={changeUrl}>submit</button>
                </div>
            </div>
            <div className='w-1/2 h-full flex items-center justify-center'>
                <img className='h-full w-full' src={homeSvg} alt="" />
            </div>
        </div>
    )
}

export default Auth