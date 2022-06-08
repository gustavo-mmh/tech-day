import PropTypes from "prop-types";

import { Navigate } from "react-router-dom";
import AUTHCallback from "../commons/hooks/AUTHCallback";

const RequireAuth = ({ children, redirectTo }) => {
  const { isAuthenticated } = AUTHCallback;

  return isAuthenticated ? children : <Navigate to={redirectTo} replace />;
};
RequireAuth.propTypes = {
  children: PropTypes.any.isRequired,
  redirectTo: PropTypes.string.isRequired,
};
export default RequireAuth;
