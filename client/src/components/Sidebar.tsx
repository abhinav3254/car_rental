import React, { useEffect, useState } from 'react'
import ChatCard from './ChatCard';
import { chats } from '../constants/Chat';
import { Chat } from '../interfaces/Chat';

type Props = {
    sendSelectedUser: (chat: Chat) => void;
}

const Sidebar = ({ sendSelectedUser }: Props) => {

    const [selectedUser, setSelectedUser] = useState<Chat>();

    const handleSelectedUser = (selectUser: Chat) => {
        setSelectedUser(selectUser);
    }

    useEffect(() => {
        if (selectedUser) {
            sendSelectedUser(selectedUser);
        }
    }, [selectedUser]);

    return (
        <div className='fixed h-screen bg-gray-100 overflow-scroll'>
            <div className='flex flex-col gap-2 p-2 pr-3'>
                {chats.map((data, key) => (
                    <ChatCard chat={data} key={key} sendSelectedUser={handleSelectedUser} />
                ))}
            </div>
        </div>
    )
}

export default Sidebar