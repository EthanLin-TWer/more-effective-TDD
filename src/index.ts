export const babelWorksWithExports = () => true

export class TypeScriptCalculator {
  private readonly number: number
  constructor(number) {
    this.number = number
  }

  add(one): string {
    return this.number + one
  }
}
