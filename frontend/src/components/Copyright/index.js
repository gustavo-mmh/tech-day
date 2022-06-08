import React from 'react'
import Link from '../Link/index';
import Typography from '../Typography/index';
function Copyright(props) {
    return (
        <Typography
            variant="body2"
            color="text.secondary"
            align="center"
            {...props}
        >
            {"Copyright © "}
            <Link color="inherit" href="https://github.com/gustavo-mmh">
                Desafio Tech Day
            </Link>{" "}
            {new Date().getFullYear()}
            {"."}
        </Typography>
    );
}
export default Copyright;