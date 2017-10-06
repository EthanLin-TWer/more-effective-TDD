import Money from './Money'

export default class France extends Money {
  constructor(amount: number) {
    super(amount)
  }

  public times(multiplications: number): France {
    return new France(this.amount * multiplications)
  }
}
