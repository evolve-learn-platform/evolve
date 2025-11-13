import * as React from 'react';
import NxWelcome from './nx-welcome';
import { Link, Route, Routes } from 'react-router-dom';
import { Remote1Wrapper } from './routes/remote1.wrapper';
import { Remote2Wrapper } from './routes/remote2.wrapper';

export function App() {
  return (
    <React.Suspense fallback={null}>
      <ul style={{ display: 'flex', gap: '38px' }}>
        <li>
          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/animals">Животные</Link>
        </li>
        <li>
          <Link to="/things">Вещи</Link>
        </li>
      </ul>
      <Routes>
        <Route path="/" element={<NxWelcome title="shell" />} />
        <Route path="/animals" element={<Remote1Wrapper />} />
        <Route path="/things" element={<Remote2Wrapper />} />
      </Routes>
    </React.Suspense>
  );
}

export default App;
