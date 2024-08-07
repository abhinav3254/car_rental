import React, { useEffect, useState } from 'react'
import Sidebar from '../components/Sidebar'
import { Chat } from '../interfaces/Chat'
import TopNav from '../components/TopNav';
import chatImage from '../assets/chat.svg';

export const Home = () => {

    const [selectedUser, setSelectedUser] = useState<Chat>();
    const [ws, setWs] = useState<WebSocket>();

    useEffect(() => {
        const _ws = new WebSocket('ws://localhost:8080');
        setWs(_ws);
        if (ws) {
            ws.onopen = () => {
                console.log('connected')
            }
        }

    }, [])

    const handleSelectedUser = (chat: Chat) => {
        setSelectedUser(chat);
    }

    useEffect(() => {
        if (selectedUser) {
            console.log(`in parent `, selectedUser);
        }
    }, [selectedUser]);

    return (
        <div className='flex'>
            <div className='w-1/4'>
                <Sidebar sendSelectedUser={handleSelectedUser} />
            </div>
            <div className='w-3/4 h-screen'>
                {selectedUser && (
                    <div className='w-full h-full bg-gray-50 flex flex-col py-3'>
                        <div className='h-[95%]'>
                            <TopNav selectedUser={selectedUser} />
                        </div>
                        <div className='flex items-center justify-center px-3 cursor-pointer'>
                            <input className='w-full border border-gray-200 outline-none px-4 py-2 rounded-md' type="text" placeholder='Write message here...' />
                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="size-10">
                                <path strokeLinecap="round" strokeLinejoin="round" d="M6 12 3.269 3.125A59.769 59.769 0 0 1 21.485 12 59.768 59.768 0 0 1 3.27 20.875L5.999 12Zm0 0h7.5" />
                            </svg>
                        </div>
                    </div>
                )}
                {!selectedUser && (
                    <div className='flex flex-col w-full h-full items-center justify-center'>
                        <img className='h-[50%] w-[50%]' src={chatImage} alt="" />
                        <p className='text-3xl italic text-gray-500'>Please select a user to initiate a conversation.</p>
                    </div>
                )}
            </div>
        </div>
    )
}
