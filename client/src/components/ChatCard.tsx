import React from 'react'
import { Chat } from '../interfaces/Chat'

type Props = {
    chat: Chat
    sendSelectedUser: (chat: Chat) => void;
}

const ChatCard = ({ chat, sendSelectedUser }: Props) => {

    const trimMessage = (message: string) => {
        const mLength = 35;
        if (message.length > mLength) return message.substring(0, mLength) + '...';
        else return message;
    }


    return (
        <div>
            <div className='w-full h-16 bg-green-50 py-2 px-4 flex items-center cursor-pointer hover:bg-green-200 hover:shadow-lg transition ease-in-out delay-0' onClick={() => { sendSelectedUser(chat) }}>
                <img className='h-12 w-12 rounded-full' src={chat.img} alt="" />
                <div className='ml-5 w-full'>
                    <p className='text-xl'>{chat.name}</p>
                    <div className='flex items-center justify-between w-full'>
                        <p className='text-sm text-gray-500 italic font-thin'>{trimMessage(chat.message)}</p>
                        <p className='text-sm'>{chat.time}</p>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default ChatCard