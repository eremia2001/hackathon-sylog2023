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
  Image as ImageIcon,
  CloudUpload as CloudUploadIcon,
} from "@mui/icons-material";
import { DateRangePicker, LocalizationProvider } from "@mui/x-date-pickers-pro";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";
import dayjs from "dayjs";
import { Close as CloseIcon } from "@mui/icons-material";

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
            boxShadow: 24,
            p: 5,
            bgcolor: "#FFFCFC",
          }}
        >
          <IconButton
            sx={{
              position: "absolute",
              top: 8,
              right: 8,
            }}
            onClick={handleCloseForm}
          >
            <CloseIcon />
          </IconButton>

          <div className="w-full  flex flex-row gap-24 ">
            <div className="flex flex-col w-[50%]">
              <TextField
                label="Project Name"
                value={projectName}
                onChange={handleInputChange(setProjectName)}
                margin="normal"
                className="bg-white"
              />
              <TextField
                label="Owner"
                value={projectOwner}
                onChange={handleInputChange(setProjectOwner)}
                sx={{ mt: 2, mb: 2 }}
                startAdornment={
                  <InputAdornment position="start">
                    <AccountCircle />
                  </InputAdornment>
                }
                className="bg-white"
              />
              <Autocomplete
                disablePortal
                id="combo-box-demo"
                className="w-full bg-white"
                options={projectMembers}
                sx={{ mt: 1, mb: 2 }}
                renderInput={(params) => (
                  <TextField
                    onChange={handleInputChange(setProjectMembers)}
                    {...params}
                    label="Members"
                  />
                )}
              />
            </div>
            <div className="h-full w-[50%] my-auto">
              <Paper
                onDragOver={(e) => e.preventDefault()}
                onDrop={handleFileDrop}
                sx={{
                  padding: 2,
                  mt: 1,
                  textAlign: "center",
                }}
                className="relative cursor-pointer"
                onClick={handleFileInputClick}
              >
                <IconButton color="primary" component="label" sx={{ mb: 1 }}>
                  <ImageIcon fontSize="large" />
                </IconButton>
                <Typography>
                  Bilder hierhin ziehen oder klicken zum Auswählen
                </Typography>
                <IconButton
                  color="primary"
                  component="label"
                  onClick={handleFileInputClick}
                  sx={{
                    position: "absolute",
                    bottom: 0,
                    left: 2,
                  }}
                >
                  <CloudUploadIcon />
                </IconButton>
              </Paper>
              <input
                type="file"
                id="fileInput"
                style={{ display: "none" }}
                multiple
                onChange={handleFileInputChange}
              />
            </div>
          </div>
          <TextField
            label="Description"
            value={projectDescription}
            onChange={handleInputChange(setProjectDescription)}
            margin="normal"
            multiline
            fullWidth
            rows={6}
            className="bg-white"
          />
          <LocalizationProvider dateAdapter={AdapterDayjs}>
            <DateRangePicker
              className="bg-white mt-5"
              defaultValue={[startDate, endDate]}
              disablePast
            />
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
