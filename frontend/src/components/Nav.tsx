import { NavLink } from 'react-router-dom'
import logo from '../assets/logo.svg'

const Nav = () => {
    return (
        <div className='flex items-center justify-between px-2 shadow-md fixed w-full bg-white h-[55px]'>
            <div className='flex items-center justify-start'>
                <img className='h-10 w-10 m-1' src={logo} alt="" />
                <p className='m-1 text-[20px]'>CarRentals</p>
            </div>
            <div>
                <ul className='flex items-center'>
                    <li>
                        <NavLink className='text-[20px] text-blue-500 mx-1' to='/home'>Home</NavLink>
                    </li>
                    <li>
                        <NavLink className='text-[20px] text-blue-500 mx-1' to='/profile'>Profile</NavLink>
                    </li>
                </ul>
            </div>
        </div>
    )
}

export default Nav