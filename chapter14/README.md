# Lab 3: Sorting and Searching Bike Data Records

## The Two Problems Defined

1. **Question 1**: Find the top 10 highest altitude points using sorting.
2. **Question 2**: Search for records matching a randomly selected power value.

## Why I Chose These Algorithms

- **Sorting Algorithm**: Quick Sort
  - **Justification**: Quick sort is efficient for large datasets and performs well on average. It's suitable for sorting bike records by altitude or power.

- **Searching Algorithm**: Binary Search
  - **Justification**: Binary search requires the data to be sorted, which we achieve with quick sort. It's optimal for finding exact matches in sorted arrays.

## Final Output/Results of My Analysis

See [results.txt](results.txt) for the full output.

### Total Records Loaded: 223983

### Question 1: Top 10 Highest Altitude Points
BikeDataRecord [timestamp=1142059271, distance=16979.33, heartrate=104, speed=5.235, alt=175.6, lat=39.2021, lng=-77.33447, pow=0, cad=0, degC=10.0]  
BikeDataRecord [timestamp=1142059272, distance=16984.47, heartrate=102, speed=5.328, alt=175.6, lat=39.20213, lng=-77.33451, pow=0, cad=0, degC=10.0]  
BikeDataRecord [timestamp=1142059270, distance=16974.31, heartrate=105, speed=5.132, alt=175.6, lat=39.20207, lng=-77.33442, pow=0, cad=0, degC=10.0]  
BikeDataRecord [timestamp=1142059269, distance=16968.95, heartrate=105, speed=5.076, alt=175.6, lat=39.20204, lng=-77.33438, pow=0, cad=0, degC=10.0]  
BikeDataRecord [timestamp=1142059273, distance=16989.8, heartrate=103, speed=5.43, alt=175.6, lat=39.20217, lng=-77.33455, pow=0, cad=0, degC=10.0]  
BikeDataRecord [timestamp=1142059274, distance=16995.19, heartrate=102, speed=5.505, alt=175.4, lat=39.2022, lng=-77.33459, pow=0, cad=0, degC=10.0]  
BikeDataRecord [timestamp=1142059278, distance=17018.76, heartrate=101, speed=6.27, alt=175.4, lat=39.20235, lng=-77.33478, pow=0, cad=0, degC=11.0]  
BikeDataRecord [timestamp=1142059277, distance=17012.69, heartrate=101, speed=6.0, alt=175.4, lat=39.20231, lng=-77.33474, pow=0, cad=0, degC=11.0]  
BikeDataRecord [timestamp=1142059267, distance=16959.09, heartrate=105, speed=4.936, alt=175.4, lat=39.20197, lng=-77.3343, pow=0, cad=0, degC=10.0]  
BikeDataRecord [timestamp=1142059266, distance=16953.95, heartrate=104, speed=4.871, alt=175.4, lat=39.20194, lng=-77.33426, pow=0, cad=0, degC=10.0]

### Question 2: Search for Power
The program picks a random power value from the sorted records and uses binary search to find all matches. The number of results changes depending on the random power chosen.