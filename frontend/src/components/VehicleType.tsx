import React, { useEffect, useState } from "react";
import axios from "axios";

// Interface for the form data
interface FormData {
    name: string;
    peopleCapacity: string;
    luggageCapacity: string;
    fuelType: string;
    transmissionType: string;
    averageMileage: string;
    yearOfManufacture: string;
    registrationDate: string;
    lastServiceDate: string;
    description: string;
}

const VehicleType = () => {
    const [openDialog, setOpenDialog] = useState(false);

    const [formData, setFormData] = useState<FormData>({
        name: "",
        peopleCapacity: "",
        luggageCapacity: "",
        fuelType: "",
        transmissionType: "",
        averageMileage: "",
        yearOfManufacture: "",
        registrationDate: "",
        lastServiceDate: "",
        description: ""
    });

    // get all the vehicle types
    const [vehicleTypeData, setVehicleTypeData] = useState([]);
    useEffect(() => {
        const getAllVehicleTypeData = async () => {
            try {
                const config = {
                    headers: {
                        'Authorization': 'Bearer ' + localStorage.getItem('token')
                    }
                };
                const response = await axios.get('vehicle/type', config);
                console.log(response.data);
            } catch (error) {
                console.log(error);
            }
        }
        getAllVehicleTypeData();
    }, [])

    // Function to handle form submission
    const handleSubmit = async () => {
        try {
            const config = {
                headers: {
                    'Authorization': 'Bearer ' + localStorage.getItem('token')
                }
            };
            const response = await axios.post("vehicle/type/add", formData, config);
            setOpenDialog(false);
        } catch (error) {
            console.log(error);
        }
    };

    // Function to handle input changes
    const handleInputChange = (e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement | HTMLTextAreaElement>) => {
        const { name, value } = e.target;
        setFormData(prevState => ({
            ...prevState,
            [name]: value
        }));
    };


    return (
        <div>
            <div>Admin Portal To Manage Vehicle Type</div>
            {!openDialog && (
                <div className='flex items-center bg-blue-500 w-fit text-white p-2 shadow-lg cursor-pointer' onClick={() => setOpenDialog(true)}>
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="w-6 h-6">
                        <path strokeLinecap="round" strokeLinejoin="round" d="M12 4.5v15m7.5-7.5h-15" />
                    </svg>
                    <p className="ml-2">Add vehicle type</p>
                </div>
            )}
            {openDialog && (
                <div className='flex items-center bg-red-500 w-fit text-white p-2 shadow-lg cursor-pointer' onClick={() => setOpenDialog(false)}>
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="w-6 h-6">
                        <path strokeLinecap="round" strokeLinejoin="round" d="M6 18 18 6M6 6l12 12" />
                    </svg>
                    <p className="ml-2">Close</p>
                </div>
            )}
            {openDialog && <dialog className="w-[60%] z-40 flex items-center justify-center p-5 shadow-lg relative" open>
                <div className='w-[80%]'>
                    <div className='w-full flex justify-start'>
                        <input className='border-gray-200 outline-none m-1 w-1/3' type="text" placeholder='Type Name' name="name" value={formData.name} onChange={handleInputChange} />
                        <input className='border-gray-200 outline-none m-1 w-1/3' type="number" placeholder='Passenger Capacity' name="peopleCapacity" value={formData.peopleCapacity} onChange={handleInputChange} />
                        <input className='border-gray-200 outline-none m-1 w-1/3' type="number" placeholder='Luggage Capacity' name="luggageCapacity" value={formData.luggageCapacity} onChange={handleInputChange} />
                    </div>
                    <div className='w-full flex justify-center'>
                        <select className='w-1/3 m-1 border-gray-200 outline-none' name="fuelType" value={formData.fuelType} onChange={handleInputChange}>
                            <option disabled value="">Select Fuel Type</option>
                            <option value="petrol">Petrol</option>
                            <option value="diesel">Diesel</option>
                            <option value="electric">Electric</option>
                            <option value="hybrid">Hybrid</option>
                            <option value="cng">CNG</option>
                            <option value="hydrogen">Hydrogen</option>
                        </select>
                        <select className='w-1/3 m-1 border-gray-200 outline-none' name="transmissionType" value={formData.transmissionType} onChange={handleInputChange}>
                            <option disabled value="">Select Transmission Type</option>
                            <option value="manual">Manual</option>
                            <option value="automatic">Automatic</option>
                            <option value="semi_automatic">Semi-automatic</option>
                            <option value="continuously_variable">Continuously Variable Transmission (CVT)</option>
                            <option value="dual_clutch">Dual-Clutch</option>
                        </select>
                        <input className="w-1/3 m-1" type="number" placeholder='Average Mileage' name="averageMileage" value={formData.averageMileage} onChange={handleInputChange} />
                    </div>
                    <div className="flex items-center">
                        <div className="w-1/3 mx-1">
                            <p className="text-[12px]">Year Of Manufacture</p>
                            <input className="w-full" type="date" placeholder='Year Of Manufacture' name="yearOfManufacture" value={formData.yearOfManufacture} onChange={handleInputChange} />
                        </div>
                        <div className="w-1/3 mx-1">
                            <p className="text-[12px]">Registration Year</p>
                            <input className="w-full" type="date" placeholder='Registration Year' name="registrationDate" value={formData.registrationDate} onChange={handleInputChange} />
                        </div>
                        <div className="w-1/3 mx-1">
                            <p className="text-[12px]">Last Service Date</p>
                            <input className="w-full" type="date" placeholder='Last Service Date' name="lastServiceDate" value={formData.lastServiceDate} onChange={handleInputChange} />
                        </div>
                    </div>
                    <div className="pr-2">
                        <textarea placeholder='Description' className='w-full m-1 min-h-28 max-h-28 border-gray-200 outline-none' name="description" value={formData.description} onChange={handleInputChange}></textarea>
                    </div>
                    <div className="text-center">
                        <button className="bg-red-500 shadow-xl text-white p-2 rounded-sm mx-2" onClick={() => setOpenDialog(false)}>CLOSE</button>
                        <button className="bg-green-500 shadow-xl text-white p-2 rounded-sm mx-2" onClick={handleSubmit}>SUBMIT</button>
                    </div>
                </div>
            </dialog>}
        </div>
    )
}

export default VehicleType;