import { useState } from "react";
import { useAuth } from "../context/AuthContext";
import { useNavigate } from "react-router-dom";
import { TextField, Button, Container, Typography, Box, InputAdornment } from "@mui/material";
import { AccountCircle, Lock } from "@mui/icons-material";
import styles from "../styles/Auth.module.css";

const LoginPage = () => {
  const { login } = useAuth();
  const navigate = useNavigate();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  const handleLogin = async () => {
    setError("");

    if (!username || !password) {
      setError("Usuario y contraseña son obligatorios.");
      return;
    }

    const success = await login(username, password);
    if (success) {
      navigate("/videogames");
    } else {
      setError("Usuario o contraseña incorrectos.");
    }
  };

  return (
    <Container className={styles.loginContainer} maxWidth="sm">
      <Box className={styles.loginBox}>
        <Typography variant="h4" className={styles.title}>Iniciar Sesión</Typography>

        <TextField
          fullWidth label="Usuario" margin="normal" value={username}
          onChange={(e) => setUsername(e.target.value)} className={styles.inputField}
          slotProps={{
            input: {
              startAdornment: (
                <InputAdornment position="start">
                  <AccountCircle sx={{ color: "#00ffff" }} />
                </InputAdornment>
              ),
            },
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
          fullWidth label="Contraseña" type="password" margin="normal" value={password}
          onChange={(e) => setPassword(e.target.value)} className={styles.inputField}
          slotProps={{
            input: {
              startAdornment: (
                <InputAdornment position="start">
                  <Lock sx={{ color: "#00ffff" }} />
                </InputAdornment>
              ),
            },
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

        {error && <Typography color="error" className={styles.errorMessage}>{error}</Typography>}

        <Button fullWidth variant="contained" className={styles.loginButton} onClick={handleLogin}>
          INGRESAR
        </Button>
      </Box>
    </Container>
  );
};

export default LoginPage;