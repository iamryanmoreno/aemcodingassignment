module.exports = {
  env: {
    browser: true,
    es2021: true,
  },
  parser: '@typescript-eslint/parser',  // Specifies the ESLint parser
  extends: [
    'airbnb-base',
    'plugin:@typescript-eslint/recommended',  // Uses the recommended rules from the @typescript-eslint/eslint-plugin
  ],
  parserOptions: {
    ecmaVersion: 'latest',  // Allows for the parsing of modern ECMAScript features
    sourceType: 'module',  // Allows for the use of imports
  },
  rules: {
    "curly": 1,
    "@typescript-eslint/explicit-function-return-type": [0],
    "@typescript-eslint/no-explicit-any": [0],
    "ordered-imports": [0],
    "object-literal-sort-keys": [0],
    "max-len": [1, 120],
    "new-parens": 1,
    "no-bitwise": 1,
    "no-cond-assign": 1,
    "no-trailing-spaces": 0,
    "eol-last": 1,
    "linebreak-style": 0,
    "func-style": ["error", "declaration", { "allowArrowFunctions": true }],
    "semi": 1,
    "no-var": 0
  },
};
