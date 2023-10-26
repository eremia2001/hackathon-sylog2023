import React, { useState } from "react";
import {
  Box,
  Button,
  Card,
  CardContent,
  Grid,
  IconButton,
  InputAdornment,
  Modal,
  Paper,
  TextField,
  Typography,
  Autocomplete,
} from "@mui/material";
import {
  AddCircleOutline as AddCircleOutlineIcon,
  AccountCircle,
} from "@mui/icons-material";
import { DateRangePicker, LocalizationProvider } from "@mui/x-date-pickers-pro";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";
import dayjs from "dayjs";

function PopupFormCard({ isFormOpen, handleCloseForm }) {
  // Constants
  const ngos = [{ label: "NGO 1" }, { label: "NGO 2" }];
  const today = dayjs();
  // State variables
  const [projectName, setProjectName] = useState("");
  const [projectOwner, setProjectOwner] = useState("");
  const [projectMembers, setProjectMembers] = useState(ngos);
  const [projectDescription, setProjectDescription] = useState("");
  const [droppedFiles, setDroppedFiles] = useState([]);
  const [startDate] = useState(today);
  const [endDate] = useState(today);

  // Event handlers

  const handleInputChange = (setter) => (e) => setter(e.target.value);
  const handleFileDrop = (e) => {
    e.preventDefault();
    const files = Array.from(e.dataTransfer.files);
    setDroppedFiles(files);
  };
  const handleFileInputClick = () =>
    document.getElementById("fileInput").click();
  const handleFileInputChange = (e) => {
    const files = Array.from(e.target.files);
    setDroppedFiles(files);
  };
  const handleSubmitForm = () => {
    //TODO: speichern in Datenbank
    console.log("Form submitted. Project Name: ", projectName);
    console.log("Owner: ", projectOwner);
    console.log("Members: ", projectMembers);
    console.log("Description: ", projectDescription);
    console.log("Date range: ", startDate, "-", endDate);
    console.log("Uploaded files: ", droppedFiles);
    handleCloseForm();
  };

  return (
    <div>
      <Modal open={isFormOpen} onClose={handleCloseForm}>
        <Box
          sx={{
            position: "absolute",
            top: "50%",
            left: "50%",
            transform: "translate(-50%, -50%)",
            width: "50%",
            bgcolor: "background.paper",
            boxShadow: 24,
            p: 2,
          }}
        >
          <TextField
            label="Project Name"
            value={projectName}
            onChange={handleInputChange(setProjectName)}
            margin="normal"
          />
          <TextField
            label="Owner"
            value={projectOwner}
            onChange={handleInputChange(setProjectOwner)}
            margin="normal"
            startAdornment={
              <InputAdornment position="start">
                <AccountCircle />
              </InputAdornment>
            }
          />
          <Autocomplete
            disablePortal
            id="combo-box-demo"
            options={projectMembers}
            sx={{ width: 300 }}
            renderInput={(params) => (
              <TextField
                onChange={handleInputChange(setProjectMembers)}
                {...params}
                label="Members"
              />
            )}
          />
          <Typography variant="h6" sx={{ mt: 2 }}>
            Datei-Upload:
          </Typography>
          <Paper
            onDragOver={(e) => e.preventDefault()}
            onDrop={handleFileDrop}
            sx={{
              border: "2px dashed #ccc",
              padding: 2,
              mt: 1,
              textAlign: "center",
            }}
          >
            <IconButton
              color="primary"
              component="label"
              onClick={handleFileInputClick}
              sx={{ mb: 1 }}
            >
              <AddCircleOutlineIcon fontSize="large" />
            </IconButton>
            <Typography>
              Ziehe und lege Dateien hierhin oder klicke, um Dateien
              auszuwählen.
            </Typography>
          </Paper>
          <input
            type="file"
            id="fileInput"
            style={{ display: "none" }}
            multiple
            onChange={handleFileInputChange}
          />
          <TextField
            label="Description"
            value={projectDescription}
            onChange={handleInputChange(setProjectDescription)}
            margin="normal"
            multiline
            fullWidth
            rows={6}
          />
          <LocalizationProvider dateAdapter={AdapterDayjs}>
            <DateRangePicker defaultValue={[startDate, endDate]} disablePast />
          </LocalizationProvider>
          <Grid container justifyContent="flex-end" sx={{ mt: 2 }}>
            <Button
              variant="contained"
              color="primary"
              onClick={handleSubmitForm}
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
