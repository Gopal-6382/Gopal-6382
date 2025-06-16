module.exports = {
  apps: [
    {
      name: "my-frontend",
      script: "npm",
      args: ["run", "dev"],
      exec_mode: "fork",
      interpreter: "powershell.exe",  // or "cmd.exe" if you prefer
      watch: true
    }
  ]
}
