# 🚗 Problem: Smart Ride-Sharing System

## 📘 Context

Codetropolis is introducing a digital ride-sharing platform that allows registered users to book quick and reliable transport across the city. The system must manage user registration, ride assignment, trip management, and generate useful insights. The platform should simulate a real-world experience, encouraging robust object-oriented design, modular structure, and scalable thinking.

This system will run as a simulation with predefined actions and should reflect sound design principles.

---

## ✅ Requirements & Rules

### User Roles and Profiles
- The system should distinguish between different user types, such as riders and drivers, while sharing common identity properties.
- Each user should maintain attributes relevant to their role, including ride history for riders and performance metrics for drivers.

### Vehicle Ownership and Preferences
- Each driver should be associated with a unique vehicle.
- Vehicles should have a type from a predefined list.
- Riders must be able to express preferences for specific vehicle types while requesting rides.

### Ride Request and Matching Logic
- Riders should be able to initiate a ride request by providing trip details and vehicle preferences.
- The system should determine the most appropriate available driver based on preference and availability.
- Matching logic should be open to future enhancement (e.g., prioritizing nearest or highest-rated drivers).

### Ride Lifecycle and Management
- A ride should have a clear status that evolves from request to completion or cancellation.
- Transitions should be traceable, and all actions taken during a ride must be recorded.

### Fare Calculation with Flexibility
- The ride fare should vary based on vehicle type and allow future extension to include surcharges or discounts (e.g., peak hour pricing, loyalty points).
- The fare logic should not be hardcoded within the ride itself.

### Rating and Feedback Mechanism
- Upon ride completion, a basic rating or feedback structure should be available to simulate quality tracking.
- Driver profiles should reflect their aggregated performance, which can influence future ride assignment logic.

### History and Analytics
- Riders should be able to view their trip history.
- The system should generate summaries, such as:
  - Total number of completed rides
  - Top-rated drivers
  - Most active riders
  - Ride counts per vehicle type

### Data Filtering and Sorting
- The system should support basic queries, such as:
  - Finding drivers sorted by rating
  - Finding riders whose name starts with a specific letter
  - Filtering rides by status or vehicle type

### Error Handling and Safe Operations
- Invalid operations or missing data (such as unavailable drivers or invalid IDs) should be handled safely, with clear error reporting that does not interrupt execution.

### Missing Data Handling
- Certain user properties (e.g., optional contact information or rating) may not always be present.
- The system should handle such absence gracefully, ensuring robustness.

### Reusability and Extensibility
- The system should include reusable logic applicable to different types of objects (e.g., generic reporting, logging, storage).
- Behavior and responsibilities should be cleanly separated to allow future growth.

### Modular Service Responsibilities
- Design should be modular: responsibilities such as ride matching, billing, and reporting should be delegated to separate components or services.
- This will help future engineers plug in new strategies or behaviors easily.

---

## 💡 Constraints

- Simulation should be demonstrated through a predefined sequence of operations.
- No interactive input (e.g., Scanner) should be used.
- At least 2 riders and 3 drivers should be initialized in the system.
- At least 2 ride flows should progress to completion and 1 ride must be cancelled.
- At least 1 error case (e.g., lookup failure) should be demonstrated.
- At least 1 optional value must be used and handled appropriately.
- Use of object-oriented principles such as abstraction, encapsulation, inheritance, and polymorphism is expected.
- The system should reflect a real-world mental core, avoiding tightly coupled or monolithic designs.

---

## 🖥️ Sample Output: Smart Ride-Sharing System

```

\--- Initializing System ---
Driver Registered: Alice \[Rating: 4.8 | Vehicle: SEDAN | Plate: AL1234]
Driver Registered: Bob \[Rating: 4.5 | Vehicle: SUV | Plate: BO9987]
Driver Registered: Clara \[Rating: 4.9 | Vehicle: BIKE | Plate: CL5678]
Rider Registered: Emma \[Email: [emma@citymail.com](mailto:emma@citymail.com)]
Rider Registered: John \[Email: Not Provided]

---

\--- Ride Request Simulation ---
Emma requested a SEDAN from 'Airport' to 'City Center'
Searching for available drivers...
Driver matched: Alice (SEDAN)
Driver Alice accepted the ride
Ride ID RIDE101 is now ONGOING
Driver Alice completed the ride
Ride completed successfully
Fare: ₹23.5
Feedback recorded: 5 stars

---

John requested a BIKE from 'Tech Park' to 'University'
Searching for available drivers...
Driver matched: Clara (BIKE)
Driver Clara accepted the ride
Ride ID RIDE102 is now ONGOING
Driver Clara completed the ride
Ride completed successfully
Fare: ₹12.0
Feedback recorded: 4 stars

---

Emma requested a SUV from 'Museum' to 'Hotel Grand'
Searching for available drivers...
Driver matched: Bob (SUV)
Driver Bob canceled the ride
Ride RIDE103 has been cancelled

---

\--- Invalid Operation Simulation ---
Looking up driver with ID: d999
Error: Driver not found. Please check the ID and try again.

---

\--- Reporting & Analytics ---
✅ Total Rides Completed: 2
✅ Total Rides Cancelled: 1

Top Rated Driver: Clara (4.9 stars)

Emma's Ride History:

* RIDE101 | Destination: City Center | Vehicle: SEDAN | Fare: ₹23.5

John's Ride History:

* RIDE102 | Destination: University | Vehicle: BIKE | Fare: ₹12.0

Available Drivers:

* Alice \[SEDAN]
* Bob \[SUV]
* Clara \[BIKE]

---

\--- Data Queries (Streams & Filters) ---
🔍 Riders with names starting with 'E':

* Emma

📊 Drivers sorted by rating:

1. Clara - 4.9
2. Alice - 4.8
3. Bob - 4.5

🚘 Rides by Vehicle Type:

* SEDAN: 1
* BIKE: 1
* SUV: 0 (Cancelled)

---

\--- Optional Handling Demo ---
Searching for email of Rider John...
Result: Email not provided

---

\--- Simulation Complete ---

```


To Do:
1. Remove rideer wallet check logic from complete ride
2. Make use of try, catch, throw and wriet custom exceotions
3. Build logic for user ratings
4. Output to .txt file
5. Build logic for drivers accepting rides (TTL for each)
6. Google amps api to compute distance between source and destination for fare computation and driver matching (extent current logic).
7. Do estimate time computation for ride completion and for payment compeletion process.
