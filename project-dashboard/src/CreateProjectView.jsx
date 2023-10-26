import React, {useState} from 'react';
import {
    Card,
    CardContent,
    Button,
    Modal,
    TextField,
    Box, Typography, Paper, IconButton, Autocomplete, InputAdornment, Grid,
} from '@mui/material';
import AddCircleOutlineIcon from '@mui/icons-material/AddCircleOutline';
import {AccountCircle} from "@mui/icons-material";
import {DateRangePicker} from '@mui/x-date-pickers-pro/DateRangePicker';
import dayjs from 'dayjs'
import {LocalizationProvider} from "@mui/x-date-pickers-pro";
import {AdapterDayjs} from "@mui/x-date-pickers/AdapterDayjs";

function PopupFormCard() {
    const ngos = [
        {
            label: 'NGO 1'
        },
        {
            label: 'NGO 2'
        }

    ]

    const today = dayjs()

    const [isFormOpen, setFormOpen] = useState(false);
    const [projectName, setProjectName] = useState('');
    const [projectOwner, setProjectOwner] = useState('');
    const [projectMembers, setProjectMembers] = useState(ngos);
    const [projectDescription, setProjectDescription] = useState('');
    const [droppedFiles, setDroppedFiles] = useState([]);
    const [startDate] = useState(today)
    const [endDate] = useState(today)

    const handleOpenForm = () => {
        setFormOpen(true);
    };

    const handleCloseForm = () => {
        setFormOpen(false);
    };

    const handleInputChangeProjectName = (e) => {
        setProjectName(e.target.value);
    };

    const handleInputChangeProjectOwner = (e) => {
        setProjectOwner(e.target.value);
    }

    const handleInputChangeDescription = (e) => {
        setProjectDescription(e.target.value);
    }

    const handleInputChangeMembers = (e) => {
        setProjectMembers(e.target.value);
    }


    const handleSubmitForm = () => {
        // Hier kannst du die Logik für die Formularverarbeitung einfügen
        console.log('Formular wurde abgeschickt. Eingegebener Wert: ' + projectName);
        console.log('Owner: ', projectOwner);
        console.log('Member: ', projectMembers);
        console.log('Description: ', projectDescription);
        console.log('Zeitraum: ', startDate, '-', endDate);
        console.log('Hochgeladene Dateien: ', droppedFiles);
        handleCloseForm();
    };

    const handleFileDrop = (e) => {
        e.preventDefault();
        const files = Array.from(e.dataTransfer.files);
        setDroppedFiles(files);
    };

    const handleFileInputClick = () => {
        // Öffne den Dateiauswahldialog, wenn auf das Datei-Upload-Icon geklickt wird
        document.getElementById('fileInput').click();
    };

    const handleFileInputChange = (e) => {
        const files = Array.from(e.target.files);
        setDroppedFiles(files);
    };

    return (
        <div>
            <Card sx={{maxWidth: 345}}>
                <CardContent>
                    <h2>New Project</h2>
                    <Button variant="contained" color="primary" onClick={handleOpenForm}>
                        +
                    </Button>
                </CardContent>
            </Card>

            <Modal open={isFormOpen} onClose={handleCloseForm}>
                <Box
                    sx={{
                        position: 'absolute',
                        top: '50%',
                        left: '50%',
                        transform: 'translate(-50%, -50%)',
                        width: '50%',
                        bgcolor: 'background.paper',
                        boxShadow: 24,
                        p: 2,
                    }}
                >
                    <TextField
                        id="outlined-multiline-static"
                        label="Project Name"
                        value={projectName}
                        onChange={handleInputChangeProjectName}
                        margin={"normal"}
                    />
                    <TextField
                        id="outlined-multiline-static"
                        label="Owner"
                        value={projectOwner}
                        onChange={handleInputChangeProjectOwner}
                        margin={"normal"}
                        startAdornment={
                            <InputAdornment position="start">
                                <AccountCircle/>
                            </InputAdornment>
                        }
                    />
                    <Autocomplete
                        disablePortal
                        id="combo-box-demo"
                        options={projectMembers}
                        sx={{width: 300}}
                        renderInput={(params) => <TextField onChange={handleInputChangeMembers} {...params}
                                                            label="Members"/>}
                    />
                    <Typography variant="h6" style={{marginTop: '16px'}}>
                        Datei-Upload:
                    </Typography>
                    <Paper
                        onDragOver={(e) => e.preventDefault()}
                        onDrop={handleFileDrop}
                        sx={{
                            border: '2px dashed #ccc',
                            padding: '16px',
                            marginTop: '8px',
                            textAlign: 'center',
                        }}
                    >
                        <IconButton
                            color="primary"
                            component="label"
                            onClick={handleFileInputClick}
                            sx={{marginBottom: '8px'}}
                        >
                            <AddCircleOutlineIcon fontSize="large"/>
                        </IconButton>
                        <Typography>
                            Ziehe und lege Dateien hierhin oder klicke, um Dateien auszuwählen.
                        </Typography>
                    </Paper>
                    <input
                        type="file"
                        id="fileInput"
                        style={{display: 'none'}}
                        multiple
                        onChange={handleFileInputChange}
                    />
                    <TextField
                        id="outlined-multiline-flexible"
                        label="Description"
                        value={projectDescription}
                        onChange={handleInputChangeDescription}
                        margin={"normal"}
                        multiline
                        fullWidth
                        rows={6}
                    />
                    <LocalizationProvider dateAdapter={AdapterDayjs}>
                        <DateRangePicker defaultValue={[startDate, endDate]} disablePast/>
                    </LocalizationProvider>
                    <Grid container justifyContent="flex-end">
                        <Button
                            variant="contained"
                            color="primary"
                            onClick={handleSubmitForm}
                            style={{marginTop: '16px'}}
                        >
                            Create
                        </Button>
                    </Grid>
                </Box>
            </Modal>
        </div>
    );
}

export default PopupFormCard;
