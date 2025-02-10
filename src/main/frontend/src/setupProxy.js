const { createProxyMiddleware } = require("http-proxy-middleware");

const CONTEXT_PATH = process.env.REACT_APP_CONTEXT_PATH || "/";

console.log(`Setting up proxy for API requests with context path: ${CONTEXT_PATH}`);

module.exports = function (app) {
  app.use(
    `${CONTEXT_PATH}/api`,
    createProxyMiddleware({
      target: "http://localhost:8080",
      changeOrigin: true,
      pathRewrite: { [`^${CONTEXT_PATH}/api`]: `${CONTEXT_PATH}/api` },
      logLevel: "debug", // Enable detailed logs
    })
  );

  console.log(`Proxying API calls from ${CONTEXT_PATH}/api to http://localhost:8080${CONTEXT_PATH}/api`);
};
