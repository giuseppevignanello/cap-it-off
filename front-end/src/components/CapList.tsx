import React, { useEffect, useState } from "react";
import axios from "axios";

interface Cap {
  id: number;
  name: string;
  description: string;
  photoUrl: string;
  price: number;
  isAvaible: boolean;
}

const [baseUrl, setBaseUrl] = useState<string>(
  "http://localhost:8080/api/v1.0"
);
const [caps, setCaps] = useState<Cap[]>([]);

const CapList = () => {
  useEffect(() => {
    axios.get(baseUrl).then((response) => {
      const fetchedCaps = response.data;
      setCaps(fetchedCaps);
    });
  });

  console.log(caps);

  return (
    <div>
      <ul>
        <li></li>
      </ul>
    </div>
  );
};

export default CapList;
