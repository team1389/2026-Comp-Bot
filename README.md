This is the 2026 FRC 1389 comp bot code repository! (Will rename to acutal bot name later)


# Git Workflow Guide: From Branch to Pull Request
---

### 1. Create a New Branch
Always start by ensuring your local `Dev` branch is up to date, then create a descriptive branch for your work.

```bash
# Switch to the dev branch
git checkout Dev

# Pull the latest changes from the server
git pull origin Dev

# Create and switch to a new branch
git checkout -b feature/your-feature-name
```


### 2. Make and commit changes
```bash

# Check which files you've modified
git status

# Add specific files (or use . for all files)
git add .

# Save the changes with a clear message
git commit -m "Add descriptive message about what you changed"
```


### 3. Push to remote
Make sure you are constantly pushing to remote so that others can see your progress!
```bash
# Push your branch to the remote server
git push origin feature/your-feature-name
```

### 4. Create Pull Request
When your feature is done you can generate a pull request to merge your changes into Dev
1. Navigate to this repository on github (https://github.com/team1389/2026-Comp-Bot).
2. Switch to viewing your branch and you will usually see a yellow banner saying "Compare & pull request". Click it.
3. Review the details: Ensure you are merging feature/your-feature-name into Dev.
4. Describe your changes: Explain what you did and why.
5. Click Create Pull Request.
