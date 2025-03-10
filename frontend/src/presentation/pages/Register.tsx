import { useState } from "react";
import { useAuth } from "../context/AuthContext";
import { useNavigate } from "react-router-dom";
import { TextField, Button, Container, Typography, Box, InputAdornment } from "@mui/material";
import { AccountCircle, Email, Lock } from "@mui/icons-material"; // 🔥 Importamos iconos de MUI
import styles from "../styles/Auth.module.css";

const RegisterPage = () => {
  const { register } = useAuth();
  const navigate = useNavigate();
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleRegister = async () => {
    const success = await register(username, email, password);
    if (success) navigate("/login");
    else alert("Error en registro.");
  };

  return (
    <Container className={styles.loginContainer} maxWidth="sm">
      <Box className={styles.loginBox}>
        <Typography variant="h4" className={styles.title}>
          Registrarse
        </Typography>

        <TextField
          fullWidth
          label="Usuario"
          margin="normal"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          className={styles.inputField}
          InputProps={{
            startAdornment: (
              <InputAdornment position="start">
                <AccountCircle sx={{ color: "#00ffff" }} />
              </InputAdornment>
            ),
          }}
          sx={{
            "& label": { color: "#00ffff" },
            "& label.Mui-focused": { color: "#00aaaa" },
            "& .MuiOutlinedInput-root": {
              "& fieldset": { borderColor: "#00ffff", borderWidth: "2px" },
              "&:hover fieldset": { borderColor: "#00aaaa" },
              "&.Mui-focused fieldset": { borderColor: "#00cccc" },
              backgroundColor: "rgba(0, 0, 0, 0.5)",
              borderRadius: "8px",
            },
            input: { color: "#ffffff" },
          }}
        />

        <TextField
          fullWidth
          label="Correo"
          margin="normal"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          className={styles.inputField}
          InputProps={{
            startAdornment: (
              <InputAdornment position="start">
                <Email sx={{ color: "#00ffff" }} />
              </InputAdornment>
            ),
          }}
          sx={{
            "& label": { color: "#00ffff" },
            "& label.Mui-focused": { color: "#00aaaa" },
            "& .MuiOutlinedInput-root": {
              "& fieldset": { borderColor: "#00ffff", borderWidth: "2px" },
              "&:hover fieldset": { borderColor: "#00aaaa" },
              "&.Mui-focused fieldset": { borderColor: "#00cccc" },
              backgroundColor: "rgba(0, 0, 0, 0.5)",
              borderRadius: "8px",
            },
            input: { color: "#ffffff" },
          }}
        />

        <TextField
          fullWidth
          label="Contraseña"
          type="password"
          margin="normal"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          className={styles.inputField}
          InputProps={{
            startAdornment: (
              <InputAdornment position="start">
                <Lock sx={{ color: "#00ffff" }} />
              </InputAdornment>
            ),
          }}
          sx={{
            "& label": { color: "#00ffff" },
            "& label.Mui-focused": { color: "#00aaaa" },
            "& .MuiOutlinedInput-root": {
              "& fieldset": { borderColor: "#00ffff", borderWidth: "2px" },
              "&:hover fieldset": { borderColor: "#00aaaa" },
              "&.Mui-focused fieldset": { borderColor: "#00cccc" },
              backgroundColor: "rgba(0, 0, 0, 0.5)",
              borderRadius: "8px",
            },
            input: { color: "#ffffff" },
          }}
        />

        <Button
          fullWidth
          variant="contained"
          className={styles.loginButton}
          onClick={handleRegister}
        >
          REGISTRARSE
        </Button>
      </Box>
    </Container>
  );
};

export default RegisterPage;