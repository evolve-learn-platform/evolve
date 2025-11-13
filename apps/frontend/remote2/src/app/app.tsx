import { EvolvePlatformSharedUi } from '@evolve-platform/shared-ui';
import { useEffect, useState } from 'react';
// import { EvolvePlatformSharedUi } from '@evolve-platform/shared-ui';
type Item = {
  id: number;
  name: string;
  description: string;
};

export function App() {
  const [things, setThings] = useState<Item[]>([]);

  useEffect(() => {
    fetch('http://localhost:8080/things')
      .then((res) => res.json())
      .then((data) => setThings(data))
      .catch((err) => console.error('Ошибка при загрузке вещей:', err));
  }, []);

  return (
    <div>
      <EvolvePlatformSharedUi />
      <h2>Список вещей:</h2>
      {things.length === 0 ? (
        <p>Загрузка...</p>
      ) : (
        <ul>
          {things.map((item) => (
            <li key={item.id}>
              <strong>{item.name}</strong>: {item.description}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}

export default App;
