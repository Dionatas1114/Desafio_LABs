import * as React from 'react';
import { useNavigate } from 'react-router-dom';
import {
  Avatar,
  Button,
  CssBaseline,
  TextField,
  Box,
  Container,
} from '@mui/material';
import { createTheme, ThemeProvider } from '@mui/material/styles';

import logo from '../../images/magalu.jpeg';
import api from '../../api';

const theme = createTheme();

export default function SignIn() {
  const navigate = useNavigate();

  function redirect() {
    return navigate('/home');
  }

  async function handleSubmit(event) {
    event.preventDefault();
    const data = new FormData(event.currentTarget);

    await api
      .post('/api/login', {
        name: data.get('name'),
        password: data.get('password'),
      })
      .then(() => redirect())
      .catch(
        alert('Os dados informados estão incorretos, por favor verifique!')
      );
  }

  return (
    <ThemeProvider theme={theme}>
      <Container component="main" maxWidth="xs">
        <CssBaseline />
        <Box
          sx={{
            marginTop: 10,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
          }}
        >
          <Avatar alt="Magalu" src={logo} sx={{ width: 100, height: 100 }} />
          <Box
            component="form"
            onSubmit={handleSubmit}
            noValidate
            sx={{ mt: 4 }}
          >
            <TextField
              margin="normal"
              required
              fullWidth
              id="name"
              label="Insert your name"
              name="name"
              autoComplete="name"
              autoFocus
            />
            <TextField
              margin="normal"
              required
              fullWidth
              name="password"
              label="Insert your password"
              type="text"
              id="password"
              autoComplete="current-password"
            />
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}
            >
              Login
            </Button>
          </Box>
        </Box>
      </Container>
    </ThemeProvider>
  );
}
