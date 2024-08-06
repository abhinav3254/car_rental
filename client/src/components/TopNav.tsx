import React from 'react'
import { Chat } from '../interfaces/Chat'

type Props = {
    selectedUser: Chat
}

const TopNav = ({ selectedUser }: Props) => {
    return (
        <div className='pr-2'>
            <div className='bg-green-500 shadow-md px-3 py-2 flex items-center'>
                <img className='w-10 h-10 rounded-full' src={selectedUser.img} alt="" />
                <p className='ml-4 text-lg'>{selectedUser.name}</p>
            </div>
        </div>
    )
}

export default TopNav