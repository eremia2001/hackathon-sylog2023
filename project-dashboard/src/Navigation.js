import React, {Component} from 'react';
import { AppBar, Toolbar, Typography, Tab, Tabs } from '@mui/material';

class Navigation extends Component {
    render() {
            return (
                <AppBar position="static">
                    <Toolbar>
                        <Typography variant="h6">Your Web App</Typography>
                        <Tabs>
                            <Tab label="My Projects" />
                            <Tab label="Discover" />
                            <Tab label="Task Management" />
                        </Tabs>
                    </Toolbar>
                </AppBar>
            );
        }
}

export default Navigation;