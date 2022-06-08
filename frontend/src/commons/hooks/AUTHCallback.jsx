import React, { useEffect } from "react";
import { useAuth } from "react-use-auth";

const AUTHCallback = () => {
  const { handleAuthentication } = useAuth();
  useEffect(() => {
    handleAuthentication();
  }, [handleAuthentication]);
  return <h1>Loading...</h1>;
};

export default AUTHCallback;
