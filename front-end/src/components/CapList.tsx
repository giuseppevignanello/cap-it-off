import React, { useEffect, useState } from "react";
import axios, { AxiosResponse } from "axios";

const CapList = () => {
  interface Cap {
    id: number;
    name: string;
    description: string;
    photoUrl: string;
    price: number;
    isAvailable: boolean;
  }

  const [baseUrl, setBaseUrl] = useState<string>(
    "http://localhost:8080/api/v1.0"
  );
  const [caps, setCaps] = useState<Cap[]>([]);

  useEffect(() => {
    axios.get(baseUrl).then((response: AxiosResponse<Cap[]>) => {
      const fetchedCaps = response.data;
      setCaps(fetchedCaps);
      console.log(caps);
    });
  }, []);

  return (
    <div>
      {caps.length > 0 ? (
        caps.map((cap) => (
          <div className="card" key={cap.id}>
            {cap.name}
          </div>
        ))
      ) : (
        <p>No caps available.</p>
      )}
    </div>
  );
};

export default CapList;
