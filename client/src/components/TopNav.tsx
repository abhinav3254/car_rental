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
                <div className='ml-4'>
                    <p className='text-lg'>{selectedUser.name}</p>
                    <p className='text-[10px] italic'>Last Seen 2hrs ago</p>
                </div>
            </div>
        </div>
    )
}

export default TopNav