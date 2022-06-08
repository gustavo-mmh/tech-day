import Layout from '../components/Layout/index';
import { lazy } from 'react';
// IMPORTS pages ADMIN
const Product = lazy(() => import('../pages/Admin/Products/'));
const User = lazy(() => import('../pages/Admin/Users/'));

const routes = () => [
    {
        path: '/admin/usuarios',
        component: User,
        layout: Layout,
        exact: true,
    },
    {
        path: '/admin/produtos',
        component: Product,
        layout: Layout,
        exact: true,
    },

];
export default routes;