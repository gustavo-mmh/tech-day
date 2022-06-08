import { Suspense } from "react";
import { BrowserRouter, Route, Routes, Navigate } from "react-router-dom";

import LoginPage from "pages/Login";
import RequireAuth from "./RequireAuth";

import routes from "./routes";

const appRoutes = routes();

const Loading = () => <p>Loading...</p>;

const Router = () => (
  <BrowserRouter>
    <Routes>
      {appRoutes.map(
        ({
          path,
          component: Component,
          layout: Layout,
          exact,
          ...routeProps
        }) => (
          <Route
            path={path}
            key={path}
            exact
            element={
              <RequireAuth redirectTo="/login">
                <Layout>
                  <Suspense fallback={<Loading full />}>
                    <Component {...routeProps} />
                  </Suspense>
                </Layout>
              </RequireAuth>
            }
          />
        )
      )}
      <Route exact path="/login" element={<LoginPage />} />

      <Route path="/" element={<Navigate replace to="/login" />} />
    </Routes>
  </BrowserRouter>
);
export default Router;
