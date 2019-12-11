import { babelWorksWithExports, TypeScriptCalculator } from './index'

it('should jest and babel works for ES6 import/export', () => {
  expect(babelWorksWithExports()).toEqual(true)
})

it('should typescript works', () => {
  expect(new TypeScriptCalculator(1).add(1)).toEqual(2)
})
