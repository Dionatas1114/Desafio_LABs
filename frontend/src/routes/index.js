import React from 'react';
import { Routes as AppRoutes, Route } from 'react-router-dom';

import Login from '../components/Login';
import HomePage from '../components/HomePage';

export default function Routes() {
  return (
    <AppRoutes>
      <Route path="/*" element={<Login />} />
      <Route path="/home" element={<HomePage />} />
    </AppRoutes>
  );
}
