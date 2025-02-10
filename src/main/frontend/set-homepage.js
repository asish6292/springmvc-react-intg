const fs = require("fs");

const newHomepage = process.argv[2] || "/";

const packageJsonPath = "./package.json";
const packageJson = JSON.parse(fs.readFileSync(packageJsonPath, "utf8"));

packageJson.homepage = newHomepage;
fs.writeFileSync(packageJsonPath, JSON.stringify(packageJson, null, 2));

console.log(`Updated homepage to: ${newHomepage}`);
