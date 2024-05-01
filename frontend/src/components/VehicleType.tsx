import React, { useState } from "react";
import Datepicker from "react-tailwindcss-datepicker";

const VehicleType = () => {
    const [startDate, setStartDate] = useState(new Date());
    const [endDate, setEndDate] = useState(new Date().setMonth(11));

    const handleStartDateChange = (date: any) => {
        console.log("startDate:", date);
        setStartDate(date);
    };

    const handleEndDateChange = (date: any) => {
        console.log("endDate:", date);
        setEndDate(date);
    };

    return (
        <div>
            <div>Admin Portal To Manage Vehicle Type</div>
            <div className='flex items-center bg-blue-500 w-fit text-white p-2 shadow-lg cursor-pointer'>
                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="w-6 h-6">
                    <path strokeLinecap="round" strokeLinejoin="round" d="M12 4.5v15m7.5-7.5h-15" />
                </svg>
                <p>Add vehicle type</p>
            </div>

            {/* add vehicle type components */}
            <div className='w-1/2'>
                <div className='w-full flex justify-start'>
                    <input className='border-gray-200 outline-none m-1 w-1/3' type="text" placeholder='Type Name' />
                    <input className='border-gray-200 outline-none m-1 w-1/3' type="number" placeholder='passenger-capacity' />
                    <input className='border-gray-200 outline-none m-1 w-1/3' type="number" placeholder='luggage-capacity' />
                </div>
                <div className='w-full flex justify-center'>
                    <select className='w-1/2 m-1 border-gray-200 outline-none'>
                        <option disabled value="">Select Fuel Type</option>
                        <option value="petrol">Petrol</option>
                        <option value="diesel">Diesel</option>
                        <option value="electric">Electric</option>
                        <option value="hybrid">Hybrid</option>
                        <option value="cng">CNG</option>
                        <option value="hydrogen">Hydrogen</option>
                    </select>
                    <select className='w-1/2 m-1 border-gray-200 outline-none'>
                        <option disabled value="">Select Transmission Type</option>
                        <option value="manual">Manual</option>
                        <option value="automatic">Automatic</option>
                        <option value="semi_automatic">Semi-automatic</option>
                        <option value="continuously_variable">Continuously Variable Transmission (CVT)</option>
                        <option value="dual_clutch">Dual-Clutch</option>
                    </select>
                </div>
                <div>
                    <input type="number" placeholder='average-mileage' />
                    <input type="number" placeholder='registration-year' />
                    <input type="text" placeholder='last-service-date' />

                    <Datepicker
                        value={startDate}
                        onChange={handleStartDateChange}
                    />
                    <Datepicker
                        value={endDate}
                        onChange={handleEndDateChange}
                    />

                </div>
                <div>
                    <textarea placeholder='Desciption' className='w-full m-1 min-h-28 max-h-28 border-gray-200 outline-none'></textarea>
                </div>
            </div>
        </div>
    )
}

export default VehicleType