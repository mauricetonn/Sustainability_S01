import { Outlet, Link } from "react-router-dom";

// Dient zur Erstellung der Navigationslinks ganz oben
// Dient nur zum Testing
// Sobald die Links im DropDown Menü sind, wird Layout entfernt

const Layout = () => {
  return (
    <>
      <nav>
        <ul>
          <li>
            <Link to="/">Home</Link>
          </li>
          <li>
            <Link to="/browse">Browse</Link>
          </li>
        </ul>
      </nav>

      <Outlet />
    </>
  )
};

export default Layout;