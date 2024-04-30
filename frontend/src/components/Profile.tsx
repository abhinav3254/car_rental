import { useEffect, useState } from 'react';
import axios from 'axios';
import { ProfileData } from './interfaces/Profile';



const Profile = () => {
    const [profile, setProfile] = useState<ProfileData | null>(null);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const config = {
                    headers: {
                        'Authorization': 'Bearer ' + localStorage.getItem('token')
                    }
                };
                const response = await axios.get<ProfileData>('auth/profile', config);
                setProfile(response.data);
            } catch (error) {
                console.error('Error fetching profile data:', error);
            }
        };
        fetchData();
    }, []);


    return (
        <div>
            {profile && (
                <div>
                    <p>Name: {profile.name}</p>
                    <p>Email: {profile.email}</p>
                    {profile.profilePhoto && (
                        <img src={`data:image/jpeg;base64, ${profile.profilePhoto}`} alt="Profile Photo" />
                    )}
                </div>
            )}
        </div>
    );
};

export default Profile;
