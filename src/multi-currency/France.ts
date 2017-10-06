export default class France {
  private amount: number

  constructor(amount: number) {
    this.amount = amount
  }

  public times(multiplications: number): France {
    return new France(this.amount * multiplications)
  }

  public equals(dollar: France): boolean {
    if (dollar === null) {
      return false
    }

    return this.amount === dollar.amount
  }
}
