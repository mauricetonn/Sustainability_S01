import React from "react";
import Toolbar from "@material-ui/core/Toolbar";
import AppBar from "@material-ui/core/AppBar";
import Typography from "@material-ui/core/Typography";
import IconButton from "@material-ui/core/IconButton";
import Button from "@material-ui/core/Button";
import MenuIcon from "@material-ui/icons/Menu";

// Erstellt Header, der dann in Browser.js und Home.js importiert wird
// MUI AppBar wird verwendet
// Menu Icon braucht noch DropDown funktion, um zwischen Paths zu wechseln

const Header = () => {
    return (
        <div>
          <h2 style = {{padding: "10px"}}>BW BANK Helping Hand Giro</h2>
          <AppBar position="static" color= "white">
            <Toolbar>
              <IconButton
                edge="start"
                style={{
                  marginRight: 20,
                }}
                color="inherit"
                aria-label="menu"
              >
                <MenuIcon />
              </IconButton>
              <Typography
                variant="h6"
                style={{
                  flexGrow: 1,
                }}
              >
                Dashboard
              </Typography>
              <Button color="inherit">Logout</Button>
            </Toolbar>
          </AppBar>
        </div>
      );
}

export default Header